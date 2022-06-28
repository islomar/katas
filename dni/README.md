# Kata DNIShould
- Origin of the kata: https://github.com/SoftwareCraftersMurcia/dni-kata
- I used tha kata to explore:
  - using notifications instead of exceptions (with [vavr Either](https://www.baeldung.com/vavr-either)
  - using a factory method

## TODO
- "21 515717E": valid, trim it and save it correctly.
- Simplify DNIErrors: it does not need a list right now...
- Is "DNI" a good name, since it might keep a NIE as well? Should it be called something else? Should I model two different value objects?
  - The description of the kata is wrong/misleading... a NIE is not a DNI.