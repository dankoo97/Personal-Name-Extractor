# Personal-Name-Extractor
CS350, Old Dominion Univ., Spring 2022  
Team teamname5  
* https://trello.com/b/kukJ39lF/cs350-personal-name-extractor

## Design

### Initial Draft

```
@startuml

title Classes - Class Diagram


class Archivist {
  +trainArchivist()
  +extractPersonalNames()
}

class Block{
  -string text
  -Collection<Token> tokens
  + string outputMarkedNames()
  + separateIntoTokens()
}

class Token{
  -String rawToken
  - ? tokenClassification
  -Feature features
}

class FeatureSet{
  +merge() 
}

@enduml
```
