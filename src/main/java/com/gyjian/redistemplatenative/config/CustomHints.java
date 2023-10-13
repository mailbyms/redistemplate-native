package com.gyjian.redistemplatenative.config;

import com.gyjian.redistemplatenative.entity.GptResultDto;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class CustomHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.reflection().registerType(GptResultDto.class, MemberCategory.INVOKE_PUBLIC_METHODS);
    }

}
