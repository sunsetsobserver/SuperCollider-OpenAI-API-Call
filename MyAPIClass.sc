MyAPIClass : Object {

    // A class method to call the API asynchronously
    *getResponseAsync { |prompt, callback|
        var apiKey, endpoint, jsonBody, cmd;

        apiKey = "YOUR-API-KEY"; // Replace with your valid API key
        endpoint = "https://api.openai.com/v1/chat/completions";

        jsonBody = "{" ++
            "\"model\": \"gpt-4o-mini\"," ++
            "\"messages\": [" ++
            "  {\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}," ++
            "  {\"role\": \"user\", \"content\": \"" ++ prompt ++ "\"}" ++
            "]" ++
            "}";

        cmd = "curl -X POST " ++ endpoint ++ " " ++
              "-H \"Content-Type: application/json\" " ++
              "-H \"Authorization: Bearer " ++ apiKey ++ "\" " ++
              "-d '" ++ jsonBody ++ "'";

        // Run the curl command asynchronously in a Routine
        Routine({
            var output, parsed, answer;

            // Execute the API call
            output = cmd.unixCmdGetStdOut;

            // Parse JSON response
            parsed = output.parseJSON;

            // Extract the response
            answer = parsed["choices"][0]["message"]["content"];

            // Print result
            answer.postln;

            // Run callback function with the result
            { callback.value(answer) }.defer; // Ensure execution in the main SC thread
        }).play;
    }
}
