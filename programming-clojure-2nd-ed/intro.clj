;;;; 05.aug.15

;;; p. 3
(defn blank? [str]
  (every? #(Character/isWhitespace %) str))

;;; p. 4
(defrecord Person [first-name last-name])

(def joe (->Person "Joe" "King"))

;;; p. 12
(defn hello [name] (str "Hello, " name))

(hello "Ken")

;;; p. 20
;;; to view source code

(use 'clojure.repl)
(source identity)

