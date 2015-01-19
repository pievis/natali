%========================================================
% USER DEFINED system configuration: robotplanned.pl
%======================================================== 		 
context(  alarmsnd, "localhost",  "TCP", "8099" ).
context(  helloreactive, "localhost",  "TCP", "8090" ).  

%%% sytem part
qactor( robterminal, mind ).	
%%% user part
qactor( alarmsnd,   alarmsnd ).
qactor( helloreactive,   helloreactive ).
