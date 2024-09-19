# RegexValidator

This project implements a system that converts regular expressions to Deterministic Finite Automata (DFA) through the intermediate step of creating Non-deterministic Finite Automata (NFA). It's designed to validate input strings against the given regular expression.

## Project Structure
The project consists of the following Java classes:

1. **ExpressionReader.java:** The main class that handles user input and orchestrates the conversion and validation process.
2. **RegularExpression.java:** Implements the algorithms for converting regular expressions to NFA and then to DFA.
3. **NFA.java:** Represents a Non-deterministic Finite Automaton.
4. **DFA.java:** Represents a Deterministic Finite Automaton.
5. **State.java:** Represents a state in both NFA and DFA, managing transitions and accept states.
6. **ValidateExpression.java:** Validates input strings against the generated DFA.

## Features

* Converts regular expressions to NFA using Thompson's construction algorithm.
* Converts NFA to DFA using the subset construction algorithm.
* Supports the following regular expression operations:
* Concatenation (.)
* Union (|)
* Kleene Star (*)
* Grouping with parentheses ()
* Validates input strings against the generated DFA.
* Handles epsilon transitions.

## Usage

1. Run the **ExpressionReader** class.
2. Enter a regular expression when prompted. Use '|' for OR operations and avoid spaces between characters.
3. Enter input strings to validate against the regular expression. Enter 'x' to terminate input.
4. According to the regular expression, the program will output whether each input string is valid or invalid.

## Implementation Details
### Regular Expression to NFA Conversion

* The RegularExpression class implements Thompson's construction algorithm to convert the **regular expression** to an NFA.
* It uses a stack-based approach to handle different operations (concatenation, union, Kleene star).

### NFA to DFA Conversion

* The subset construction algorithm is implemented in the RegularExpression class to convert the NFA to a DFA.
* Epsilon closure is computed for each state set.

### String Validation

The **ValidateExpression** class traverses the DFA for each input string to determine if it's accepted by the regular expression.

### Limitations

* The alphabet is limited to 'a' and 'b'.
* The empty string is represented by 'e'.

## Future Improvements

* Extend the alphabet to support more characters.
* Implement more advanced regular expression features like character classes and quantifiers.
* Optimize the algorithms for better performance with complex regular expressions.
* Add a graphical user interface for easier interaction.
 
