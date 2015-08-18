;;;; Testing for empty sequence when iterating
;;;; use (seq s) instead of (not (empty? s))


;;;; Joy of Clojure, 2nd ed.
;;; p. 96q

;;; For vectors, using peek instead of last is faster
;;; Use conj, not assoc
;;; Use pop, not dissoc, nor butlast, for shrinking it

;;; p. 104
;;; to check if any of a set of values are contained in a sequence, use
;;; (some #{1 :b} [:a :b 1 2])

