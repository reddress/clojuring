;;;; 05.aug.15

;;; p. 14

(conj #{} "John")

(def visitors (atom #{}))

;;; (swap! reference update-fn & args)

(swap! visitors conj "Steph")

@visitors

;;; or

(deref visitors)

(defn hello
  "Writes 'Hello name'. Saves names to visitors atom"
  [username]
  (println (str "Hello " (if (some #{username} @visitors) "again " "") username))
  (swap! visitors conj username)
  nil)
