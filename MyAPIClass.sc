MyAPIClass : Object {

    // A class method to call the API with a custom prompt.
    *getResponse { |prompt|
        var apiKey, endpoint, jsonBody, cmd, output, parsed, answer;

        // Your API key (this is hidden from your live code display)
        apiKey = "YOUR-API-KEY"; // Replace with your valid API key

        // API endpoint
        endpoint = "https://api.openai.com/v1/chat/completions";

        // Build the JSON request body manually with the dynamic prompt.
        jsonBody = "{" ++
            "\"model\": \"gpt-4o-mini\"," ++
            "\"messages\": [" ++
            "  {\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}," ++
            "  {\"role\": \"user\", \"content\": \"" ++ prompt ++ "\"}" ++
            "]" ++
            "}";

        // Construct the curl command
        cmd = "curl -X POST " ++ endpoint ++ " " ++
              "-H \"Content-Type: application/json\" " ++
              "-H \"Authorization: Bearer " ++ apiKey ++ "\" " ++
              "-d '" ++ jsonBody ++ "'";

        // Execute the command and capture its output
        output = cmd.unixCmdGetStdOut;

        // Parse the JSON response into a Dictionary
        parsed = output.parseJSON;

        // Extract the answer from the parsed JSON
        answer = parsed["choices"][0]["message"]["content"];

        // Print and return the answer
        "Answer:".postln;
        answer.postln;
        ^answer;
    }
}
