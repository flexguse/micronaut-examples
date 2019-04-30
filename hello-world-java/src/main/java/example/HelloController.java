/*
 * Copyright 2017 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example;

import example.dto.HelloWorldInput;
import example.dto.HelloWorldOutput;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.validation.constraints.NotBlank;

/**
 * @author Graeme Rocher, Christoph Guse
 * @since 1.0
 */
@Controller("/")
@Validated
public class HelloController {

    /**
     * Use this endpoint for a simple greeting.
     */
    @Get(uri = "/hello/{name}", produces = MediaType.TEXT_PLAIN)
    public Single<String> hello(@NotBlank String name) {
        return Single.just("Hello " + name + "!");
    }

    /**
     * Use this endpoint for the advanced greeting.
     */
    @Post(uri = "/hello", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public Single<HelloWorldOutput> hello(@NotBlank @RequestBody HelloWorldInput input) {

        return Single.just(HelloWorldOutput
                .builder()
                .greeting(String.format("Hello %s %s!", input.theFirstName(), input.theLastName()))
                .build());

    }

}
