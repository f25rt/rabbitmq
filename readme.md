● Instructions on how to use / run a demo (if any)
	Steps:
		1. Make sure you have RabbitMQ server setup and erlang OTP, currently this is not using any docker and it is disabled hardcoded not to use the containers
		2. Do a maven clean package to create a jar file. 
		3. run the java -jar jarfile,jar, you can locate the jar in the targets folder
● List of assumptions made (if any)
	1. Assumptions the transfer size is the input that filters which message will go on a queue. The payload in the message object was not used, I only use the transfer size to indicate the producing and consuming message
	2. Assumptions on the 500 max connection will be move to a designated backup queue instead of rerouting on the 4 queues
	3. Consumer and Producer is supposed to be separate application in order to test the extent of the message queue but here I just separated them as packages
	 