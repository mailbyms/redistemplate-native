/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gyjian.redistemplatenative;



import com.gyjian.redistemplatenative.config.CustomHints;
import com.gyjian.redistemplatenative.entity.GptResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author Christoph Strobl
 */
@Slf4j
@SpringBootApplication
@ImportRuntimeHints(CustomHints.class)
public class RedisTemplateNativeApplication implements CommandLineRunner {

	@Autowired
	RedisConnectionFactory factory;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RedisTemplateNativeApplication.class, args);
	}

	@Override
	@RegisterReflectionForBinding(GptResultDto.class)
	public void run(String... args) throws Exception {
		GptResultDto dto = new GptResultDto();
		dto.setId("cmpl-6n16oxgkfEPqMOpxlnN4VcSbqklo1");
		dto.setModel("text-davinci-003");

		// token 及 用户信息 存入redis
		redisTemplate.opsForValue().set("hello", dto, 3, TimeUnit.MINUTES);

		dto = (GptResultDto) redisTemplate.opsForValue().get("hello");

		log.info("retrieve dto: {}", dto);
	}
}
