# Personal-Name-Extractor
CS350, Old Dominion Univ., Spring 2022  
Team teamname5  
* https://trello.com/b/kukJ39lF/cs350-personal-name-extractor

## Design

### Initial Draft

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
  -int salary
  +trainPersonalNameExtractor()
  +setName()
  +getName()
  +setID()
  +getID()
  +setSalary()
  +getSalary()
}

class Document{
  -string text
  -Metadata metadata
  +readFile()
  +markPersonalNames()
  +outputDocumentWithMarkedNames()
  +addAuthor()
  +setDocumentText()
  +getDocumentText()
}
class Metadata{
  -string title
  -Collection<AuthorNames>
  -string publisher
  -Collection<string> descriptiveKeyWords
  -string abstract
  +setTitle()
  +getTitle()
  +addAuthor()
  +deleteAuthor()
  +getAuthorNames()
  +setPublisher()
  +getPublisher()
  +addDescriptiveKeyWord()
  +deleteDescriptiveKeyWord()
  +getDescriptiveKeyWords()
  +setAbstract()
  +getAbstract()
}

class AuthorNames{
  -string firstName
  -string lastName
  -string middleInitial
  -string suffix
  +setFirstName()
  +getFirstName()
  +setLastName()
  +getLastName()
  +setMiddleInitial()
  +getMiddleInitial()
  +setSuffix()
  +getSuffix()
}


@enduml
