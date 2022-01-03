JFLAGS = -g
JC = javac
JVM= java

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = persondata/Person.java \
		persondata/Ticket.java \
		persondata/Benefits.java \
		entities/Entity.java \
		entities/GroupedEntity.java \
		entities/Family.java \
		entities/Group.java \
		entities/Single.java \
		heapclasses/Node.java \
		heapclasses/BinaryHeap.java \
		boarding/Database.java \
		boarding/MainClass.java
		
MAIN = boarding/MainClass

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN)
	
clean:
	$(RM) *.class