;;;; Page numbers of when functions are first mentioned

;;; p.6   (defrecord name [arg1 arg2...])
;;; p.14  (conj coll item)
;;; p.15  (atom initial-state)  the most basic reference type
;;; p.15  (def symbol initial-value?)
;;; p.15  (swap! r update-fn & args)  applies update-fn to reference r
;;; p.16  (require quoted-namespace-symbol)  loads a library
;;; p.17  (refer quoted-namespace-symbol)  create mappings for library's names
;;; p.17  (use quoted-namespace-symbol)  requires and refers together
;;; p.18  (use :reload quoted-namespace-symbol)
;;; doc   (use :only list-of-symbols)
;;; p.18  (doc name)
;;; p.19  (find-doc s)  search a regexp inside anything outputted by doc
;;; p.20  (clojure.repl/source a-symbol)  show source code
;;; p.26  (str & args)  concatenates strings and skips nil
;;; p.27  (apply f args* argseq)  args* are optional
;;; p.27  (true? expr) (false? expr)
;;; p.28  (nil? expr) (zero? expr)
;;; p.29  (get the-map key not-found-val?)  instead of using keyword as fn
;;; p.30  (->Book "title" "author")  instantiate a record
;;; p.32  (defn name doc-str? attr-map? [params*] body)
;;; p.33  (defn name doc-str? attr-map? ([params*] body)+)  multiple arities
;;; p.35  (fn [params*] body)  anonymous function
;;; p.35  #(body % %2 %3)  shorthand, % is the same as %1
;;; p.37  (var a-symbol)  refer to a var directly, same as #' (var-quote)
;;; p.38  (let [bindings*] exprs*)  bindings are pairs, value is last expr
;;; p.40  (resolve sym)  returns the var or class resolved in current ns
;;; p.41  (in-ns 'name)  switches namespaces, but clojure.core is not referred
;;; p.41  (import '(package Class+))  only works for Java classes
;;; p.42  (require '[clojure.string :as str])
;;; p.42  (ns name & references)  unlike in-ns, clojure.core is included
;;; p.42  (ns examples.exploring (:require (...)) (:import (...)) (:use ...))
;;; p.43  (new classname)  creates a Java object
;;; p.43  (. class-or-instance member-symbol & args)  calls methods and fields
;;; p.43  (. class-or-instance (member-symbol & args))
;;; p.44  (import [& import-lists])  import-list => (package-symbol & classes)
;;; p.45  (javadoc java.net.URL)
;;; p.45  (if test then-if-true then-if-false)
;;; p.45  (do forms*)  used for side effects
;;; p.46  (loop [bindings *] exprs*)  works like let, then evaluates exprs
;;; p.46  (recur exprs*)  binds new values for loop and returns control to top
;;; p.51  (meta expr)  get metadata
;;; p.52  ^metadata form
;;; p.53  (defn name (body)+ {:tag String})  metadata map at the end
;;; p.56  (first aseq)
;;; p.56  (rest aseq)
;;; p.56  (cons elem aseq)
;;; p.56  (seq coll)  returns a seq on any seq-able collection
;;; p.56  (next aseq)  returns the seq of the rest of aseq
;;; p.57  (class expr)  returns the class of expr
;;; p.58  (sorted-set & elements)  
;;; p.59  (sorted-map & elements)
;;; p.59  (conj coll element & elements)  adds one or more elements
;;; p.59  (into to-coll from-coll)  adds all items in a collection to another
;;; p.61  (range start? end step?)  includes start (default 0) but not end
;;; p.61  (repeat n x)  repeats n times, infinitely if n is omitted
;;; p.62  (iterate f x)  begin with x and repeat forever, applying f each time
;;; p.62  (take n seq)  returns a lazy sequence of the first n items
;;; p.62  (cycle coll)
;;; p.62  (interleave & colls)
;;; p.63  (interpose separator coll)
;;; p.63  (clojure.string/join separator sequence)
;;; p.63  (list & elements)
;;; p.63  (vector & elements)
;;; p.63  (hash-set & elements)
;;; p.63  (hash-map key-1 val-1 ...)
;;; p.63  (set coll)
;;; p.64  (vec coll)
;;; p.64  (filter pred coll)
;;; p.64  (take-while pred coll)
;;; p.64  (complement f)  reverses the behavior of the function f
;;; p.64  (drop-while pred coll)
;;; p.65  (split-at index coll)
;;; p.65  (split-with pred coll)
;;; p.65  (every? pred coll)
;;; p.65  (some pred coll)
;;; p.66  (not-every? pred coll)
;;; p.66  (not-any? pred coll)
;;; p.66  (map f coll)  can take multiple collections when f takes many args
;;; p.67  (reduce f coll)  applies f on first two elements, then result to 3rd
;;; p.67  (sort comp? coll)
;;; p.67  (sort-by a-fn comp? coll)
;;; p.68  (for [binding-form coll-expr filter-expr? ...] expr)
;;; p.
;;; p.
;;; p.
;;; p.
;;; p.
;;; p.
;;; p.
;;; p.
;;; p.
