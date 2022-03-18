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
  -FeatureSet features
}

class FeatureSet{
  bool inDictionary;
  bool isCityOrState;
  bool isCountryOrTerritory;
  bool isPlace;
  bool isDTICFirstName;
  bool isDTICLastName;
  bool isCommonFirstName;
  bool isCommonLastName;
  bool isHonorific;
  bool isPrefix;
  bool isSuffix;
  bool killWord;
  +merge() 
}

@enduml
```
