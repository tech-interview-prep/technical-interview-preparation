/**
52 characters

input : perfect makes another

step1: rehtona sekam tcefrep
step2 reverse(rehtona) reverse(sekam) reverse(tcefrep) - another makes perfect

output: another makes perfect

null
[' ']
[]
[ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ', 'm', 'a', 'k', 'e', 's', '  ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

[ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' , '  ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't']


public char[] reverseSentence(char[] input) {
    if (input == null || input.length == 0) {
        return input;
    }

    input = reverse(input, 0, input.length - 1);// Step 1

    int start = 0;
    int index = 0;
    while (index < input.length) {
        if (input[index] != ' ') {
            index++;
        } else {
            reverse(input, start, index - 1);
            start = index + 1;
            index++;
        }
    }

    reverse(input, start, index - 1);

    return input;
}

private char[] reverse(char[] input, int start, int end) {
    char temp;
    while (start < end) {
        temp = input[end];
        input[end] = input[start];
        input[start] = temp;
        start++;
        end--;
    }

    return input;
}
*/