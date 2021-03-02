
### How to run application:
* Select run from the Main class in IDE.
* Application created using Java 11.
* No specific parameters are needed to run program.

## User will configure properties in app.properties File
The following options are available:
#### input.type
1. file : will accept file when provided with path and file name
2. console : will accept input via console

#### line.count
1. bottom : will provide line count given input at after input
2. top : will provide line count at top prior to processed data output

#### case.sensitivity
1. true : will return data in all uppercase format
2. false : will return data as it was received

#### output.type
1. file : will return output as a file & will ask to provide file name
2. console : will output processed data to the console

#### header.footer
1. Enter data to be returned as header, footer or both.

#### header.enabled
1. true : will print header.footer data at top of output
2. false : will not print header

#### footer.enabled
1. true : will print header.footer data at bottom of output
2. false : will not output footer

The file output will be saved to the root of the program directory.

