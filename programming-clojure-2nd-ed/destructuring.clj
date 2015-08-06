;;;; p. 39

;;; 6.aug.2015

(defn greet-author-normal [author]
  (println "Hello," (:first-name author)))

(def an-author {:last-name "Updike", :first-name "John"})

(greet-author-normal an-author)

;;; a map destructures an associative collection, matching the key inside
;;; the argument value
(defn greet-author-destruct [{fname :first-name}]
  (println "Hello," fname))

(greet-author-destruct an-author)

;;; p. 40
(defn ellipsize 
  "Takes the first three words and adds ... after them"
  [words]
  (let [[w1 w2 w3] (clojure.string/split words #"\s+")]
    (clojure.string/join " " [w1 w2 w3 "..."])))

(ellipsize "Eggses, potatoes, tomatoes, bananas, and a pumpkin")

