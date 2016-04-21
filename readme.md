
This utility allow user to send mail without using Java Mail API.

Utility work on “mailto” protocol which is in java.net package. User has to give from recipient,  protocol, subject and message in main method and to recipients will be picked up from txt file.

Format of recipients file is given below:
FileName: “Recipient.txt”
e.g.
Email	,	status
Mukundchouhan220@gmail.com , active		   
Mukundchouhan220@gmail.com , deactive		   


System will pick only those entries which have active status.
