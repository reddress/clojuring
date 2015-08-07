;;;; Page numbers of when functions are first mentioned

;;; after finishing reading the book, sort lines by function, with Clojure

;;; p.6   (defrecord name [arg1 arg2...])
;;; p.14  (conj coll item)
;;; p.15  (atom initial-state)  the most basic reference type
;;; p.15  (def symbol initial-value?)
;;; p.15  (swap! r update-fn & args)  applies update-fn to reference r
;;; p.16  (require quoted-namespace-symbol)  loads a library
;;; p.17  (refer quoted-namespace-symbol)  create mappings for library's names
;;; p.17  (use quoted-namespace-symbol)  requires and refers together
;;; p.18  (use :reload quoted-namespace-symbol)
;;; (doc) (use :only list-of-symbols)
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
;;; p.35  (fn name? [params*] body)  anonymous function
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
;;; (doc) (drop n coll)  returns a lazy seq of all but first n items
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
;;; p.70  (doall coll)  forces evaluation of coll (realize fully)
;;; p.70  (dorun coll)  walks coll without keeping past elements in memory
;;; p.72  (re-matcher regexp string)  not recommended, use re-seq instead
:;; p.72  (re-find m)
;;; p.73  (re-seq regexp string)
;;; p.74  (file-seq dir)  a depth-first tree seq
;;; p.74  (count coll)
;;; p.74  (clojure.java.io/reader)
;;; p.74  (with-open ...)
;;; p.75  (line-seq rdr)
;;; p.76  (clojure.xml/parse file)
;;; p.76  (xml-seq root)
;;; p.77  (peek '(1 2 3)) -> 1
;;; p.77  (pop '(1 2 3)) -> (2 3)  list cannot be empty
;;; p.77  (peek [1 2 3]) -> 3
;;; p.77  (pop [1 2 3]) -> [1 2]
;;; p.77  (get vec index)
;;; p.78  ([:a :b :c] 1) -> :b
;;; p.78  (assoc [0 1 2 3 4] 2 :two) -> [0 1 :two 3 4]
;;; p.78  (subvec vec start end?)
;;; p.78  (keys map)
;;; p.78  (vals map)
;;; p.79  (get map key value-if-not-found?)
;;; p.79  (:key {:key "val"})  keywords are functions
;;; p.80  (contains? map key)  tests for the presence of a key
;;; p.80  (dissoc map key & ks)  returns a map with the given keys removed
;;; p.80  (select-keys map keyseq)  keeps only keyseq keys
;;; p.80  (merge & maps)  combines maps, giving preference to rightmost map
;;; p.81  (merge-with merge-fn & maps)  fn combines values with the same key
;;; p.81  (concat x y & z)  concatenates elements in given colls
;;; p.82  ('clojure.set/union
;;; p.82  ('clojure.set/intersection
;;; p.82  ('clojure.set/difference
;;; p.82  ('clojure.set/select 
;;; p.83  (rename relation rename-map)
;;; p.83  (select pred relation)
;;; p.83  (project relation keys)
;;; p.83  (join relation-1 relation-2 keymap?)
;;; p.92  (letfn [fnspecs] & body)
;;; p.94  (lazy-seq & body)
;;; p.97  (lazy-cat & colls)
;;; p.99  (when-let binding-form-test & body)
;;; p.100 (partition size step? coll)
;;; p.101 (defonce a-symbol initial-value?)  sets root binding if it's not set
;;; p.101 (defn- name & args-as-for-defn)  function private to its namespace
;;; p.101 (comp f & fs)  composes two or more functions
;;; p.102 (partial f & partial args)
;;; p.106 (trampoline f & partial-args)
;;; p.
;;; p.
;;; p.
;;; p.
;;; p.
;;; p.
;;; p.
;;; p.
;;; p.
;;; p.
