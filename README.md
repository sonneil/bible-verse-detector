# Overview

This application intent is to make it easier to project Bible texts during services using speech recognition to identify Bibles book, chapter and verses. 
When running it will listening to Voice Commands and try to send the Bible texts LIVE using OpenLP.

Program design consist in a Five Steps Flow triggered by each Voice Command detected.

Given a StepInput:
- Extraction: Extracts from it a StepResult with Data & ResultStatusCode. 
- Validation: Perform validations over input and provides a StepResult with a ResultStatusCode.
- Actions: Prepare a List of Action types to be executed. (In the Prototype this Step executes the Action List)
- Selection: Selects which Actions are going to be executed.
- Execution: Execute the Actions List.

I provide a DefaultImplementation for the Flow Steps using OpenLP to project the Bible texts. It requires [OpenLP](https://openlp.org/) to be installed and running, remote interface enabled, Authentication enabled (I've hardcoded the user/pass in GoLiveOpenLPConfig.OPENLP_USERNAME, GoLiveOpenLPConfig.OPENLP_PASSWORD for this prototype but this is going to be deleted soon).

# How to Use
1 - Download and extract "bible-detector.zip" located in bin folder.
2 - Download [OpenLP](https://openlp.org/). At the moment writing this I'm using version 3.1.6.
3 - Open OpenLP and make sure:
    a - Remote Interface has "User Authentication" checked and it matches {GoLiveOpenLPConfig.OPENLP_USERNAME, GoLiveOpenLPConfig.OPENLP_PASSWORD}.
    b - Host and Port matches GoLiveOpenLPConfig config.
4 - Start the program running bible-detector/START.bat
