1

It looks like serializing/deserializing class hierarchies is a common problem.

There is even an "official" solution, inside extras directory of the official source repo (unfortunately it is not part of the Maven package though).

Please check:

The explanation: https://blog.novatec-gmbh.de/gson-object-hierarchies/
The solution: https://github.com/google/gson/blob/master/extras/src/main/java/com/google/gson/typeadapters/RuntimeTypeAdapterFactory.java. It is suggested to just copy/paste the source.