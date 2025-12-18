#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAPE_SIZE 1000
#define BLANK '_'

// Turing Machine States
typedef enum
{
    Q_START,    // Initial state
    Q_SCAN,     // Scanning for the target character
    Q_FOUND,    // Found target character, mark it
    Q_CONTINUE, // Continue scanning
    Q_ACCEPT    // Accept state (finished)
} State;

// Turing Machine structure
typedef struct
{
    char tape[TAPE_SIZE];
    int head_position;
    State current_state;
    char target_char;
    int count;
} TuringMachine;

// Initialize the Turing Machine
void init_turing_machine(TuringMachine *tm, const char *input, char target)
{
    int len = strlen(input);

    // Initialize tape with input string, rest with blanks
    for (int i = 0; i < TAPE_SIZE; i++)
    {
        if (i < len)
        {
            tm->tape[i] = input[i];
        }
        else
        {
            tm->tape[i] = BLANK;
        }
    }

    tm->head_position = 0;
    tm->current_state = Q_START;
    tm->target_char = target;
    tm->count = 0;
}

// Print current state of the Turing Machine (for debugging)
void print_tm_state(TuringMachine *tm, int show_tape)
{
    printf("State: ");
    switch (tm->current_state)
    {
    case Q_START:
        printf("Q_START");
        break;
    case Q_SCAN:
        printf("Q_SCAN");
        break;
    case Q_FOUND:
        printf("Q_FOUND");
        break;
    case Q_CONTINUE:
        printf("Q_CONTINUE");
        break;
    case Q_ACCEPT:
        printf("Q_ACCEPT");
        break;
    }
    printf(" | Head: %d | Count: %d", tm->head_position, tm->count);

    if (show_tape)
    {
        printf(" | Tape: ");
        for (int i = 0; i < 50 && tm->tape[i] != BLANK; i++)
        {
            if (i == tm->head_position)
            {
                printf("[%c]", tm->tape[i]);
            }
            else
            {
                printf("%c", tm->tape[i]);
            }
        }
    }
    printf("\n");
}

// Simulate the Turing Machine
void simulate_turing_machine(TuringMachine *tm)
{
    char current_symbol;

    while (tm->current_state != Q_ACCEPT)
    {
        current_symbol = tm->tape[tm->head_position];

        // State transition rules
        switch (tm->current_state)
        {
        case Q_START:
            // Start scanning from the beginning
            tm->current_state = Q_SCAN;
            break;

        case Q_SCAN:
            if (current_symbol == BLANK)
            {
                // Reached end of input, go to accept state
                tm->current_state = Q_ACCEPT;
            }
            else if (current_symbol == tm->target_char)
            {
                // Found target character
                tm->current_state = Q_FOUND;
            }
            else
            {
                // Not the target character, move right
                tm->head_position++;
                // Stay in Q_SCAN state
            }
            break;

        case Q_FOUND:
            // Mark this character as counted (replace with lowercase or special marker)
            // Increment counter
            tm->count++;
            // Mark the character (we'll use a lowercase version or keep original)
            // For simplicity, we'll just mark it with a special character
            tm->tape[tm->head_position] = '*'; // Mark as counted
            tm->current_state = Q_CONTINUE;
            break;

        case Q_CONTINUE:
            // Move right to continue scanning
            tm->head_position++;
            tm->current_state = Q_SCAN;
            break;

        case Q_ACCEPT:
            // Already in accept state, exit loop
            break;
        }
    }
}

// Main function
int main()
{
    char input_string[TAPE_SIZE];
    char target_char;
    TuringMachine tm;

    printf("=== Turing Machine: Character Counter ===\n\n");

    // Get input string
    printf("Enter the input string: ");
    if (fgets(input_string, sizeof(input_string), stdin) == NULL)
    {
        printf("Error reading input string.\n");
        return 1;
    }

    // Remove newline character if present
    int len = strlen(input_string);
    if (len > 0 && input_string[len - 1] == '\n')
    {
        input_string[len - 1] = '\0';
    }

    // Get target character
    printf("Enter the character to count: ");
    if (scanf(" %c", &target_char) != 1)
    {
        printf("Error reading target character.\n");
        return 1;
    }

    printf("\n--- Initializing Turing Machine ---\n");
    printf("Input string: %s\n", input_string);
    printf("Target character: '%c'\n\n", target_char);

    // Initialize Turing Machine
    init_turing_machine(&tm, input_string, target_char);

    printf("--- Starting Simulation ---\n");
    print_tm_state(&tm, 1);

    // Simulate the Turing Machine
    simulate_turing_machine(&tm);

    printf("\n--- Simulation Complete ---\n");
    print_tm_state(&tm, 1);

    // Display result
    printf("\n=== Result ===\n");
    printf("The character '%c' appears %d time(s) in the string \"%s\"\n",
           target_char, tm.count, input_string);

    return 0;
}
