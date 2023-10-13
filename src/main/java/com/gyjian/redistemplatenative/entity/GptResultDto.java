package com.gyjian.redistemplatenative.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * gpt 接口返回的消息格式
 */
@Data
public class GptResultDto {
    String id;
    JsonNode choices;
    String model;

            /*
    {
        "id": "cmpl-6n16oxgkfEPqMOpxlnN4VcSbqklo1",
            "object": "text_completion",
            "created": 1677140354,
            "model": "text-davinci-003",
            "choices": [
        {
            "text": "？ AIBot:您叫智灵姐姐。",
                "index": 0,
                "logprobs": null,
                "finish_reason": "stop"
        }
    ],
        "usage": {
        "prompt_tokens": 76,
                "completion_tokens": 22,
                "total_tokens": 98
    }
    }

             */


}
