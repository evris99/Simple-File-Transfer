# Simple-File-Transfer
A simple server and client where the client sends files and the server receives them.

To easily generate the .jar files you can execute the package_to_jar.sh script.
To run the server execute:
    java -jar server.jar
To run the client execute:
    java -jar client.jar server_ip_address file1 file2 ...
    
The server can handle multiple clients and the client uses one thread for each file to decrease the run-time.
