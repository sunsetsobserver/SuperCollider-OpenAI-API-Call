# SuperCollider-OpenAI-API-Call

This repository contains a SuperCollider extension that encapsulates an API call to OpenAI's chat completions endpoint. The extension provides a `MyAPIClass` with a method `getResponse` that takes a custom prompt as an argument and returns the API's response.

## Setup Instructions

1. **Clone or Download the Repository**

   Clone this repository to your local machine or download it as a ZIP file and extract it:

   ```bash
   git clone https://github.com/yourusername/SuperCollider-OpenAI-API-Call.git
   ```

2. **Locate Your SuperCollider Extensions Folder**

   The extensions folder is typically located at:

   - **macOS:** `~/Library/Application Support/SuperCollider/Extensions`
     Go -> Go to folder... -> ~/Library

   - **Windows:** Please refer to your SuperCollider installation documentation, or use your custom class path folder.

3. **Copy the Extension File**

   Copy the file `MyAPIClass.sc` from this repository into your SuperCollider Extensions folder.

4. **Recompile the SuperCollider Class Library**

   Re-open the SuperCollider IDE to recompile the class library.

5. **Using the Extension in Your SuperCollider Patch**

   Once the classes have been recompiled, you can call the API from your SuperCollider code. For example:

   ```supercollider
   (
   var customPrompt = "Write a haiku that explains the concept of recursion in a fun way.";
   var result = MyAPIClass.getResponse(customPrompt);
   )
   ```

   This will execute the API call with the provided prompt and print the result in the post window.

6. **API Key**

   **Important:** The API key is hard-coded in the `MyAPIClass.sc` file. **Before using the extension, replace the API key YOUR-API-KEY with your valid API key.**

## Files in the Repository

- **MyAPIClass.sc**: Contains the SuperCollider class that performs the API call.
- **README.md**: Provides instructions on how to set up and use the extension.

## Disclaimer

This code is provided "as-is", without warranty of any kind. Use it at your own risk and ensure you manage your API key securely while complying with OpenAI's usage policies.

Happy live-coding!

```

```
