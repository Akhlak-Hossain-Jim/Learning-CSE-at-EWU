#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LENGTH 1000
#define BLANK '_'

typedef enum
{
    Q_START,
    Q_SCAN,
    Q_FOUND,
    Q_CONTINUE,
    Q_ACCEPT
} State;

typedef struct
{
    char tape[LENGTH];
    int head_position;
    State current_state;
    char target_char;
    int count;
} TuringMachine;

void init_turing_machine(TuringMachine *tm, const char *input, char target)
{
    int len = strlen(input);

    for (int i = 0; i < LENGTH; i++)
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

void simulate_turing_machine(TuringMachine *tm)
{
    char current_symbol;

    while (tm->current_state != Q_ACCEPT)
    {
        current_symbol = tm->tape[tm->head_position];

        switch (tm->current_state)
        {
        case Q_START:
            tm->current_state = Q_SCAN;
            break;

        case Q_SCAN:
            if (current_symbol == BLANK)
            {
                tm->current_state = Q_ACCEPT;
            }
            else if (current_symbol == tm->target_char)
            {
                tm->current_state = Q_FOUND;
            }
            else
            {
                tm->head_position++;
            }
            break;

        case Q_FOUND:
            tm->count++;
            tm->tape[tm->head_position] = '*';
            tm->current_state = Q_CONTINUE;
            break;

        case Q_CONTINUE:
            tm->head_position++;
            tm->current_state = Q_SCAN;
            break;

        case Q_ACCEPT:
            break;
        }
    }
}

int main()
{
    char input_string[LENGTH];
    char target_char;
    TuringMachine tm;

    printf("=== Turing Machine: Character Counter ===\n\n");

    printf("Enter the input string: ");
    if (fgets(input_string, sizeof(input_string), stdin) == NULL)
    {
        printf("Error reading input string.\n");
        return 1;
    }

    int len = strlen(input_string);
    if (len > 0 && input_string[len - 1] == '\n')
    {
        input_string[len - 1] = '\0';
    }

    printf("Enter the character to count: ");
    if (scanf(" %c", &target_char) != 1)
    {
        printf("Error reading target character.\n");
        return 1;
    }

    printf("\n--- Initializing Turing Machine ---\n");
    printf("Input string: %s\n", input_string);
    printf("Target character: '%c'\n\n", target_char);

    init_turing_machine(&tm, input_string, target_char);

    printf("--- Starting Simulation ---\n");
    print_tm_state(&tm, 1);

    simulate_turing_machine(&tm);

    printf("\n--- Simulation Complete ---\n");
    print_tm_state(&tm, 1);

    printf("\n=== Result ===\n");
    printf("The character '%c' appears %d time(s) in the string \"%s\"\n",
           target_char, tm.count, input_string);

    return 0;
}
