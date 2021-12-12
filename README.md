# High-level programming languages II exam - Practice part

## Description

You will find an input file named `premier_2019-2020.csv` in the root directory of this repository.
Your task is to implement a command line application to process it.

Please read the instructions below carefully:
1. Read the input file into a `List`, handle exceptions as well
  
    Notes:
    * Necessary domain classes (in package `hu.unideb.inf.prog2.exam.domain`) have already been implemented, you do not need to modify them
    * A CSV parser (`hu.unideb.inf.prog2.exam.input.parser.MatchStatisticsCSVParser`) has been implemented as well, you can use it to read the text file into the correct format
    * A stub for the reader (`hu.unideb.inf.prog2.exam.input.reader.MatchStatisticsReader`) has been added too, in which you will need to implement the `read` method to pass this part of the exercise
    * It is enough to print a meaningful information message (e.g.: which operation has failed, why) as exception handling
1. Implement a processor to handle the input. It should not cause any side effects (e.g. printing to console) and should be able to support the following features:
   1. Retrieving the count of matches where the specified team achieved the specified result (e.g. Arsenal, A)
   1. Retrieving a list, which contains the top 3 number of scored goals by match
   1. Aggregating statistics regarding given yellow and red cards by referee name into a single `hu.unideb.inf.prog2.exam.domain.DisciplinaryActionStatistics`
      * Since referee name is a free text, finding appropriate result is not guaranteed, thus, please use Optional
1. Update the application to be able to parse the following input parameters; stop the program gracefully when the parameters are invalid (exception handling can be similar to the one used during the input file read operation)
   1. `team` of type `Team`
   1. `matchResult` of type `MatchResult`
   1. `referee` of type `String`
1. Add a new class, which has a sole purpose of handling all input data at a high-level. Use it to print a short summary of the season:
   1. Use parsed input parameters, and the processor implemented in subtask 2 to collect the necessary data
   1. Print the results of the methods from subtask 2 to the console
      1. Since the result of 2.iii can be empty, use the Optional API to print an alternate text in such cases
   
General notes:
   * Try to implement classes and methods that have clear separation of concerns; you can add as many interfaces/classes and methods as you see fit
   * Preferably use the Stream API, but you can use loops too as a fallback solution at a cost of losing points
   * You can use `hu.unideb.inf.prog2.exam.input.supplier.InputDataSupplier` as input data source if you get stuck
     at the first subtask (similarly to the previous one, this should be a fallback solution which comes at a price of losing points)
   * Avoid [Pokemon exception handling](https://wiki.c2.com/?PokemonExceptionHandling)

## Example expected outputs

Below you can find some examples of expected outputs based on various input data that you can use to
check the correctness of your program.

### Datasource: file

#### Inputs:

   * Team: "Aston Villa"
   * Match result: A
   * Referee: "J Moss"

#### Outputs:

   * Match count: 2
   * Top 3 goals count: 9, 8, 8
   * Given cards: yellow: 92, red: 2

---

#### Inputs:

   * Team: "Tottenham"
   * Match result: H
   * Referee: "C Pawson"

#### Outputs:

   * Match count: 12
   * Top 3 goals count: 9, 8, 8
   * Given cards: yellow: 84, red: 2

---

#### Inputs:

   * Team: "Chelsea"
   * Match result: D
   * Referee: "L Mason"

#### Outputs:

   * Match count: 6
   * Top 3 goals count: 9, 8, 8
   * Given cards: yellow: 60, red: 1

### Datasource: input provider class

#### Inputs:

   * Team: "Aston Villa"
   * Match result: A
   * Referee: "J Moss"

#### Outputs:

   * Match count: 0
   * Top 3 goals count: 5, 5, 4
   * Given cards: yellow: 7, red: 1

---

#### Inputs:

   * Team: "Tottenham"
   * Match result: H
   * Referee: "C Pawson"

#### Outputs:

   * Match count: 1
   * Top 3 goals count: 5, 5, 4
   * Given cards: yellow: 1, red: 0

---

#### Inputs:

   * Team: "Chelsea"
   * Match result: D
   * Referee: "L Mason"

#### Outputs:

   * Match count: 1
   * Top 3 goals count: 5, 5, 4
   * Given cards: yellow: 5, red: 0
