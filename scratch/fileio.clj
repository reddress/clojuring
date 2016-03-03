;;;; 03.mar.2016
;;;; try writing a string to a file

(+ 2 3)

(defn f [] "abc
αβγ
def")

(spit "abc.txt" (f))

(spit "f.txt" f)
