;;;; Mon Aug 10 16:37:39 BRT 2015

;;; p.35  #(body % %2 %3)  shorthand, % is the same as %1
;;; p.82  ('clojure.set/difference
;;; p.82  ('clojure.set/intersection
;;; p.82  ('clojure.set/select 
;;; p.82  ('clojure.set/union
;;; p.144 (-> ...)
;;; p.30  (->Book "title" "author")  instantiate a record
;;; p.43  (. class-or-instance (member-symbol & args))
;;; p.43  (. class-or-instance member-symbol & args)  calls methods and fields
;;; p.79  (:key {:key "val"})  keywords are functions
;;; p.78  ([:a :b :c] 1) -> :b
;;; p.123 (agent initial-state options*)  :validator fn  :meta metadata-map 
;;; p.125 (agent-errors ...)
;;; p.217 (aget java-array index)
;;; p.217 (alength java-array)
;;; p.194 (alias short-name-symbol namespace-symbol)
;;; p.118 (alter ref update-fn & args)
;;; p.218 (amap a idx ret expr)
;;; p.179 (and & exprs)
;;; p.27  (apply f args* argseq)  args* are optional
;;; p.219 (areduce a idx ret init expr)
;;; p.217 (aset java-array index value)
;;; p.184 (assert expr)
;;; p.78  (assoc [0 1 2 3 4] 2 :two) -> [0 1 :two 3 4]
;;; p.122 (atom initial-state options?)  :validator fn  :meta metadata-map
;;; p.15  (atom initial-state)  the most basic reference type
;;; p.124 (await & agents)  causes current thread to block, no timeout
;;; p.124 (await-for timeout-millis & agents)
;;; p.128 (binding [bindings] & body)  have dynamic scope inside a thread
;;; p.135 (butlast ...)
;;; p.57  (class expr)  returns the class of expr
;;; p.125 (clear-agent-errors agent)  returns to pre-error state
;;; p.74  (clojure.java.io/reader)
;;; p.20  (clojure.repl/source a-symbol)  show source code
;;; p.63  (clojure.string/join separator sequence)
;;; p.76  (clojure.xml/parse file)
;;; p.179 (comment & exprs)
;;; p.119 (commute ref update-fn & args)  preferably use alter
;;; p.101 (comp f & fs)  composes two or more functions
;;; p.64  (complement f)  reverses the behavior of the function f
;;; p.81  (concat x y & z)  concatenates elements in given colls
;;; p.146 (condp ...)
;;; p.59  (conj coll element & elements)  adds one or more elements
;;; p.14  (conj coll item)
;;; p.56  (cons elem aseq)
;;; p.80  (contains? map key)  tests for the presence of a key
;;; p.74  (count coll)
;;; p.180 (create-struct & key-symbols)
;;; p.62  (cycle coll)
;;; p.181 (declare & names)
;;; p.108 (declare ...)
;;; p.15  (def symbol initial-value?)
;;; p.147 (definterface name & sigs)
;;; p.167 (defmacro name doc-str? attr-map? [params*] body)
;;; p.109 (defmethod ...)
;;; p.190 (defmethod name dispatch-val & fn-tail)  :default may be dispatch
;;; p.109 (defmulti ...)
;;; p.189 (defmulti name dispatch-fn)
;;; p.53  (defn name (body)+ {:tag String})  metadata map at the end
;;; p.33  (defn name doc-str? attr-map? ([params*] body)+)  multiple arities
;;; p.32  (defn name doc-str? attr-map? [params*] body)
;;; p.101 (defn- name & args-as-for-defn)  function private to its namespace
;;; p.101 (defonce a-symbol initial-value?)  sets root binding if it's not set
;;; p.148 (defprotocol name & opts+sigs)
;;; p.157 (defrecord name [& fields] & opts+specs)  specialized type like map
;;; p.239 (defspec ...)
;;; p.180 (defstruct name & key-symbols)
;;; p.152 (deftype name [& fields] & opts+specs)
;;; p.182 (delay & exprs)
;;; p.116 (deref reference)
;;; p.197 (derive child parent)
;;; p.236 (dir ns)
;;; p.80  (dissoc map key & ks)  returns a map with the given keys removed
;;; p.45  (do forms*)  used for side effects
;;; p.70  (doall coll)  forces evaluation of coll (realize fully)
;;; p.18  (doc name)
;;; p.70  (dorun coll)  walks coll without keeping past elements in memory
;;; p.116 (dosync & exprs)
;;; p.209 (dotimes bindings & body)
;;; p.140 (doto ...)
;;; (doc) (drop n coll)  returns a lazy seq of all but first n items
;;; p.64  (drop-while pred coll)
;;; p.65  (every? pred coll)
;;; p.148 (extend type & proto+mmaps)
;;; p.149 (extend-protocol protocol & specs)
;;; p.149 (extend-type type & specs)
;;; p.27  (false? expr)
;;; p.74  (file-seq dir)  a depth-first tree seq
;;; p.64  (filter pred coll)
;;; p.19  (find-doc s)  search a regexp inside anything outputted by doc
;;; p.56  (first aseq)
;;; p.35  (fn name? [params*] body)  anonymous function
;;; p.68  (for [binding-form coll-expr filter-expr? ...] expr)
;;; p.183 (force x)
;;; p.236 (gen/int)
;;; p.236 (gen/vec gen/boolean)
;;; p.172 (gensym prefix?)
;;; p.79  (get map key value-if-not-found?)
;;; p.29  (get the-map key not-found-val?)  instead of using keyword as fn
;;; p.77  (get vec index)
;;; p.63  (hash-map key-1 val-1 ...)
;;; p.63  (hash-set & elements)
;;; p.45  (if test then-if-true then-if-false)
;;; p.41  (import '(package Class+))  only works for Java classes
;;; p.44  (import [& import-lists])  import-list => (package-symbol & classes)
;;; p.41  (in-ns 'name)  switches namespaces, but clojure.core is not referred
;;; p.62  (interleave & colls)
;;; p.63  (interpose separator coll)
;;; p.59  (into to-coll from-coll)  adds all items in a collection to another
;;; p.218 (into-array type? seq)
;;; p.191 (isa? child parent)
;;; p.62  (iterate f x)  begin with x and repeat forever, applying f each time
;;; p.45  (javadoc java.net.URL)
;;; p.83  (join relation-1 relation-2 keymap?)
;;; p.78  (keys map)
;;; p.97  (lazy-cat & colls)
;;; p.94  (lazy-seq & body)
;;; p.38  (let [bindings*] exprs*)  bindings are pairs, value is last expr
;;; p.92  (letfn [fnspecs] & body)
;;; p.75  (line-seq rdr)
;;; p.63  (list & elements)
;;; p.46  (loop [bindings *] exprs*)  works like let, then evaluates exprs
;;; p.170 (macroexpand form)
;;; p.170 (macroexpand-1 form)
;;; p.217 (make-array class dim & more-dims)
;;; p.66  (map f coll)  can take multiple collections when f takes many args
;;; p.111 (memoize f)
;;; p.80  (merge & maps)  combines maps, giving preference to rightmost map
;;; p.81  (merge-with merge-fn & maps)  fn combines values with the same key
;;; p.51  (meta expr)  get metadata
;;; p.118 (my-update-fn thing-to-update & optional-other-args)
;;; p.43  (new classname)  creates a Java object
;;; p.56  (next aseq)  returns the seq of the rest of aseq
;;; p.28  (nil? expr)
;;; p.66  (not-any? pred coll)
;;; p.66  (not-every? pred coll)
;;; p.42  (ns examples.exploring (:require (...)) (:import (...)) (:use ...))
;;; p.42  (ns name & references)  unlike in-ns, clojure.core is included
;;; p.179 (or & exprs)
;;; p.102 (partial f & partial args)
;;; p.100 (partition size step? coll)
;;; p.77  (peek '(1 2 3)) -> 1
;;; p.77  (peek [1 2 3]) -> 3
;;; p.77  (pop '(1 2 3)) -> (2 3)  list cannot be empty
;;; p.77  (pop [1 2 3]) -> [1 2]
;;; p.193 (prefer-method multi-name preferred-dispatch less-preferred-disp)
;;; p.83  (project relation keys)
;;; p.139 (proxy ...)
;;; p.214 (proxy class-and-interfaces super-cons-args & fns)
;;; p.139 (proxy-super ...)
;;; p.61  (range start? end step?)  includes start (default 0) but not end
:;; p.72  (re-find m)
;;; p.72  (re-matcher regexp string)  not recommended, use re-seq instead
;;; p.73  (re-seq regexp string)
;;; p.46  (recur exprs*)  binds new values for loop and returns control to top
;;; p.67  (reduce f coll)  applies f on first two elements, then result to 3rd
;;; p.115 (ref initial-state options)  :validator fn  :meta metadata-map
;;; p.116 (ref-set reference new-value)
;;; p.17  (refer quoted-namespace-symbol)  create mappings for library's names
;;; p.162 (reify & opts+specs)
;;; p.83  (rename relation rename-map)
;;; p.61  (repeat n x)  repeats n times, infinitely if n is omitted
;;; p.42  (require '[clojure.string :as str])
;;; p.235 (require '[clojure.test.generative.generators :as gen])
;;; p.16  (require quoted-namespace-symbol)  loads a library
;;; p.122 (reset! an-atom newval)  sets the value of an atom
;;; p.40  (resolve sym)  returns the var or class resolved in current ns
;;; p.56  (rest aseq)
;;; p.83  (select pred relation)
;;; p.80  (select-keys map keyseq)  keeps only keyseq keys
;;; p.123 (send an-agent update-fn & args)  like commuting a ref
;;; p.126 (send-off ...)  used for actions that expect to block
;;; p.56  (seq coll)  returns a seq on any seq-able collection
;;; p.63  (set coll)
;;; p.130 (set! var-symbol new-value)  should be used rarely
;;; (doc) (slurp f & opts)
;;; p.65  (some pred coll)
;;; p.67  (sort comp? coll)
;;; p.67  (sort-by a-fn comp? coll)
;;; p.59  (sorted-map & elements)
;;; p.58  (sorted-set & elements)  
;;; p.205 (spit file content)
;;; p.65  (split-at index coll)
;;; p.65  (split-with pred coll)
;;; p.26  (str & args)  concatenates strings and skips nil
;;; p.195 (struct ...)
;;; p.78  (subvec vec start end?)
;;; p.123 (swap! an-atom f & args)  calls f plus additional args
;;; p.15  (swap! r update-fn & args)  applies update-fn to reference r
;;; p.62  (take n seq)  returns a lazy sequence of the first n items
;;; p.64  (take-while pred coll)
;;; p.218 (to-array seq)  always creates an Object array
;;; p.106 (trampoline f & partial-args)
;;; p.27  (true? expr)
;;; p.206 (try expr* catch-clause* finally-clause?)
;;; p.158 (update-in ...)
;;; p.198 (use '[clojure.inspector :only (inspect-tree)])
;;; p.199 (use '[clojure.test :only (is)])
;;; (doc) (use :only list-of-symbols)
;;; p.18  (use :reload quoted-namespace-symbol)
;;; p.17  (use quoted-namespace-symbol)  requires and refers together
;;; p.78  (vals map)
;;; p.37  (var a-symbol)  refer to a var directly, same as #' (var-quote)
;;; p.64  (vec coll)
;;; p.63  (vector & elements)
;;; p.171 (when test & body)
;;; p.99  (when-let binding-form-test & body)
;;; p.171 (when-not test & body)
;;; p.74  (with-open ...)
;;; p.205 (with-open [name init-form] & body)
;;; p.183 (with-out-str & exprs)
;;; p.76  (xml-seq root)
;;; p.28  (zero? expr)
;;; p.194 ::keyword  will resolve in the current namespace
;;; p.116 @reference  same as deref
;;; p.52  ^metadata form
;;; p.172 `form  syntax quote
;;; p.172 prefix#  inside syntax-quoted, create gensym
;;; p.172 ~@  splicing unquote
;;; p.172 ~form  unquote