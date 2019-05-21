# Simple-File-Transfer
A simple server and client where the client sends files and the server receives them.

To easily generate the .jar files on linux execute:
    `./package_to_jar.sh`

To run the server execute:
    `java -jar server.jar`
    
To run the client execute:
    `java -jar client.jar Server_IP_Address file1 file2 ...`

The server can handle multiple clients and the client uses one thread for each file to decrease the run-time.
