# JSON Processing Samples for Java

There are several ways to process JSON data in Java. Some of the simpler tools are:

* https://code.google.com/archive/p/json-simple/
* https://github.com/google/gson

The Product Class will use JSON-Simple
The Inventory Class will use Gson

## Installing JSON-Simple

Download the [json-simple-1.1.1.jar](https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/json-simple/json-simple-1.1.1.jar)
and place it somewhere within your NetBeans Project Path. I typically use a `lib`
folder, or just place it in the project root folder.

On the NetBeans `Libraries` node for your Project, right-click and select "Add 
JAR/Folder". Navigate to your project folder, and select the JAR file. This
should indicate a relative path to the file, not an absolute path.

*NOTE*: If you use an absolute path, your project will not be portable.

## Installing Gson

Download the [gson-2.8.0.jar](http://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.0/gson-2.8.0.jar)
and place it somewhere within your NetBeans Project Path. I typically use a `lib`
folder, or just place it in the project root folder.

On the NetBeans `Libraries` node for your Project, right-click and select "Add 
JAR/Folder". Navigate to your project folder, and select the JAR file. This
should indicate a relative path to the file, not an absolute path.

*NOTE*: If you use an absolute path, your project will not be portable.
