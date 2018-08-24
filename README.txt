I've done all of the RSA stuff for you, BUT that means that every single person that downloads this client will have the same
keys as you. THIS IS NOT SAFE. Generate new keys using the generator provided and add the public ones to the "Constants" class
in the client, and the private ones to the "Session" class in the server.

If you cannot run the "RSAKeyGen" class, because it says that the main method is missing or whatever then follow the steps.
presented below. Alternatively if it works fine and you get your new keys then you're good to go.



IF THE ABOVE DOESN'T WORK: YOU WILL HAVE TO ADD THE RSA FOLDER AS A SOURCE FOLDER TO GENERATE NEW KEYS!!! FOR 
ECLIPSE USERS, RIGHT CLICK ON THE PROJECT FILE (SHOULD BE NAMED "asteria_client") -> NEW -> SOURCE FOLDER -> TYPE 
"rsa" FOR THE FOLDER NAME, THEN CLICK FINISH

THEN RIGHT CLICK THE "keys" PACKAGE (SHOULD BE GREYED OUT) -> BUILD PATH -> EXCLUDE

THEN TO RUN IT, JUST RIGHT CLICK ON THE "RSAKeyGen" JAVA FILE -> RUN AS -> JAVA APPLICATION

THE PUBLIC AND PRIVATE KEYS WILL BE GENERATED IN THE "keys" FOLDER.