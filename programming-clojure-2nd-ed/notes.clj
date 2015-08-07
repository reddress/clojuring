;;;; Programming Clojure, 2nd Ed.

;;; The special variables *1, *2, and *3 stores the three most recent
;;; expressions. *e holds the last exception

;;; (/ 1 0)

;;; p. 19
;;; (find-doc regexp) will search documentation that matches the given regexp
;;; It searches inside the contents so may return a lot of functions

;;; p. 20
;;; to view source code

(use 'clojure.repl)
(source identity)

;;; p. 29
;;; Because data structures are immutable, any data structure can be a key
;;; in a map

;;; p. 65
;;; Sets act as functions. #{\a\e\i\o\u} is the function that tests to see
;;; whether its argument is a vowel.
