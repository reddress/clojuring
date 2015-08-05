;;;; 05.aug.15

;;; p. 16

;;; a library packages code and belongs to a namespace. They are analogous
;;; to a Java package.

(require 'clojure.java.io)

;;; lazy seq fibonacci p. 94
(defn lazy-seq-fibo
  ([]
   (concat [0 1] (lazy-seq-fibo 0 1)))
  ([a b]
   (let [n (+ a b)]
     (lazy-seq
      (cons n (lazy-seq-fibo b n))))))

(take 10 (lazy-seq-fibo))

;;; required names must be used as fully qualified names. Instead, using
;;; (refer quoted-namespace) creates mappings for all the library's names
;;; in the current namespace.

;;; But refer can only be used after require.
;;; (use quoted-namespace) does both in a single step

;;; (use :reload 'examples.intro) will force a library to reload
