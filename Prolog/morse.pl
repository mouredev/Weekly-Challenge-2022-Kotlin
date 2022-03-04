% Runs on Scryer Prolog
%
% scryer-prolog morse.pl
%
% ?- solve("TEXT or MORSE", Output).
%
:- use_module(library(dcgs)).
:- use_module(library(lists)).
:- use_module(library(reif)).

morse("a", ".-").
morse("b", "-...").
morse("c", "-.-.").
morse("ch", "----").
morse("d", "-..").
morse("e", ".").
morse("f", "..-.").
morse("g", "--.").
morse("h", "....").
morse("i", "..").
morse("j", ".---").
morse("k", "-.-").
morse("l", ".-..").
morse("m", "--").
morse("n", "-.").
morse("ñ", "--.--").
morse("o", "---").
morse("p", ".--.").
morse("q", "--.-").
morse("r", ".-.").
morse("s", "...").
morse("t", "-").
morse("u", "..-").
morse("v", "...-").
morse("w", ".--").
morse("x", "-..-").
morse("y", "-.--").
morse("z", "--..").
morse("0", "-----").
morse("1", ".----").
morse("2", "..---").
morse("3", "...--").
morse("4", "....-").
morse("5", ".....").
morse("6", "-....").
morse("7", "--...").
morse("8", "---..").
morse("9", "----.").
morse(".", ".-.-.-").
morse(",", "--..--").
morse("?", "..--..").
morse("\"", ".-..-.").
morse("/", "-..-.").

morse_string(Morse) -->
    {
	morse([X,Y], M0),
	append_morse(M0, M1, Morse)
    },
    [X,Y],
    morse_string(M1).

morse_string(Morse) -->
    {
	append(" ", M0, Morse)
    },
    " ",
    morse_string(M0).

morse_string(Morse) -->
    {
	morse([X], M0),
        append_morse(M0, M1, Morse)
    },
    [X],
    morse_string(M1).

morse_string([]) --> [].

text_morse(Text, Morse) :-
    once(phrase(morse_string(Morse), Text)).

append_morse(M0, M1, Morse) :-
    if_(M1 = "", append(M0, M1, Morse), append(M0, [' '|M1], Morse)).

solve(Input, Output) :-
    text_morse(Output, Input) ; text_morse(Input, Output).

