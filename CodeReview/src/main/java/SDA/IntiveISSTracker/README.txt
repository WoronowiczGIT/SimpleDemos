Template:
JSONReceiver:
- Connects to API,
- Checks connection
- Returns JSON as String
- Returns null in case of connection error.

JSONtoPOJO:
- Converts JSON String into java JSONObject
- Converts JSONObject into Position Object
- Returns Position Object
- Returns null in case of invalid String

Logic:
- Contains converting methods that use Position objects
- Does not validate input data - therefore declared abstract

DataRepository:
- Uses methods of Logic Class to create DataPackage Object

Main:


Bugs:
Figure out why time stamp is fucked
(is it API fault or need to implement multithreading)
ToDo:
Implement NULLPosition
