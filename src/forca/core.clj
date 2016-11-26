"This is an simples force game play"
"Author: Marcelo Santos"
(ns forca.core
    (:gen-class))

(def total-of-lifes 6)
(def secret-word "CLOJURE")

(defn you-lose [] (print "Você perdeu!!! "))
(defn you-win [] (print "Você ganhou!!! "))

(defn missing-letters [the-word the-hits]
	(remove (fn [the-letter] (contains? the-hits (str the-letter))) the-word))

(defn hit-the-all-word? [the-word the-hits]
	(empty? (missing-letters the-word the-hits)))

(defn read-letter! [] (read-line))

(defn has-hit? [the-shot the-word] (.contains the-word the-shot))

(defn print-the-force [the-lifes the-word the-hits]
	(println "Vidas " the-lifes)
	(doseq [the-letter (seq the-word)]
		(if (contains? the-hits (str the-letter))
		(print the-letter " ")
		(print "_" " ")))
	(println))

(defn the-game [the-lifes the-word the-hits]
	(print-the-force the-lifes the-word the-hits)
	(cond
		(= the-lifes 0) (you-lose)
		(hit-the-all-word? the-word the-hits) (you-win)
		:else
		(let [the-shot (read-letter!)]
			(if (has-hit? the-shot the-word)
				(do
					(println "Acertou a letra! ")
					(recur the-lifes the-word (conj the-hits the-shot)))
				(do
					(println "Errou a letra! ")
					(recur (dec the-lifes) the-word the-hits))))))

(defn avalia-the-shot [the-shot the-lifes the-word the-hits]
	(if (has-hit? the-shot the-word)
		(the-game the-lifes the-word (conj the-hits the-shot))
		(the-game (dec the-lifes) the-word the-hits)))

(defn start-the-game [] (the-game total-of-lifes secret-word #{}))

(defn -main [& args]
    (start-the-game))
