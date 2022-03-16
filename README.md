# Personal-Name-Extractor
CS350, Old Dominion Univ., Spring 2022  
Team teamname5  
* https://trello.com/b/kukJ39lF/cs350-personal-name-extractor

## Design

### Initial Draft

```
@startuml

title Classes - Class Diagram

class DocumentArchives{
  -Collection<Archivist>
  -Collection<Document>
  +addArchivist()
  +deleteArchivist()
  +getArchivists()
  +addDocument()
  +deleteDocument()
  +getDocuments()
  +findArchivist()
  +findDocument()
}
class Archivist {
  -string name
  -string ID
  +trainPersonalNameExtractor()
  +setName()
  +getName()
  +setID()
  +getID()
}

class Document{
  -string text
  +readFile()
  +markPersonalNames()
  +outputDocumentWithMarkedNames()
  +setDocumentText()
  +getDocumentText()
}


@enduml
```
