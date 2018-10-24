;; Some practice.

;; Some style note:
;; 1.No tabs but 2 whitespaces
;; arguments on the same line with function names
;; For the same group of arguments, donnot use commas, always whitespaces
;; chain functions: line up
;; variable name connected by - not _. _ might let the program run into problems



;; Initialize the namespace
(ns practice)

;; first hello world

;; ==
(= 1 1)

;; Clojure uses Java's object types for booleans, strings and numbers.

;; to eval a quoted list

;; (eval '(+2 4))

;; Lists are linked-list data structures
;; Vectors are array-backed.

;; str create new string out of all argugments
(str "Hello" " " "World")

;; check if lists of data

(coll? [str "cat"])

;; this will be printed out first
(print str [1 2 3])

;; list has this '
'(1 2 3)
;; vector does not
[1 2 3]

;; sequence, a kind of list
(range 4)

(seq? 
  (range 4))

;; add 5 to a list of the first 4 numbers of an infinite list
(cons 5 (
  take 4 (
    range)))

;; add lists and vectors together

(concat '(1 2 3) [1 2 3])

;; increase each element in the list by one
(map inc '(1 2 3))

;; filter
(filter even? '(1 2 3))

;; reduce to a monimal epxpression
(reduce + [1 2 3 4])

(reduce conj [2 3 44] '(1 2 3))

;;  functions always return the last statement

(fn [] "The place of the function will be returned")

;; to call the function
((fn [] "This will be printed"))

;; Variables!!

(def a 1)
(def b 2)
(+ a b)

;; define a function 

((def func 
  (fn[] (+ 1 1))))


;;returns the sum of a+b
(defn add-a-b [a b]
  (+ a b))

(add-a-b 1 2)

;; override
(defn print-name
  ([name] (str "Hello " name));; with 1 arg
  ([] (str "No name."));; without arg
  ([name1 name2](str "hey "name1 " and " name2))) ;; 2 args

(print-name)
(print-name "nene")
(print-name "nene" "ning")

;; a way to count args passed in: & args

(defn count-args[& args]
  (str "You passed " (count args) "args. " ))
(count-args "i" "am" "happy")



;; Maps
;; HashMap and ArrayMap share an interface
;; HashMap:: quicker but does not maintain a key order
;; array
{:a 1 :b 2 :c 3}
;; hash
(hash-map :a 1 :b 2 :c 3)

;; arraymaps will be converted into hashmaps when they get large.
 
;; this is an array
(class(def stringmap {"a" 1, "b" 2, "c" 3}))
(stringmap "a")

;; this is a map
(class(def stringmap {:a 1, :b 2, :c 3}))
;; to retrieve value, :key
(stringmap :a)

;; add new keys
(assoc stringmap :d 4)
;; this is not going to be stored
(stringmap :d)

;; clojure variables are immutable
;; Have to create a new one to catch the new value

(def new-stringmap (assoc stringmap :d 4))
(new-stringmap :d)

;; remove by dissoc
(dissoc new-stringmap :c )


;; Sets
;; same as JAVA, only one of the same value get stored
(class(
  def my-set (
    set [1 2 3 1 2 3])))

my-set

;; add
(conj my-set 5)
;; remove
(disj my-set 3)

;; can't remove a set. type don't match
(disj my-set #{1 2})

;; test the existence
(my-set 1)
(my-set 100)

;; if else
(if false "a" "b")

;; a function which returns max(a b)-min(a b)
(defn return-substraction [a b]
 (if (> a b) (- a b) (- b a)))

(return-substraction 10 40)
(return-substraction 20 10)

;; to group statements together
;; "world" comes in first andbthey is(print'hello')
(do 
  (print "Hello")
  "World")
(do "world"
  (print "hello"))

;; functions have implicit dos
;; 
(defn print-all [name]
  (print "say hello to " name)
  (str "hello" name)
)
(print-all "nene")

;; let to create temporary bidings
(let [nene 1 ning 2]
nene
ning)
;; notice a same instruction in the same snipet will overwrite the previous one

(let [name "nene"]
  (print "hello, " name)
  (str "ok " name))

;; put the first snipet into the following LINKED

( (-> {:nene 1 :ning 2}
  (assoc :ningkko 3)
  (dissoc :nene))
  stringmap :ningkko
  )

;; ->> inserts he result ofbthe previous one to the ned of the snipet

(->>
  (range 5)
  ;; increaase by one
  ;; (map inc ( range(5) ))
  (map inc)
  ;; (filter even? (map inc( range(5))))
  (filter even?))


(->>
  (range 10)
  (map dec);; decrease by one
  (filter odd?)
  (into []));; into put studff into the following expression

;; the as-> macro, insert snippets to targget places

(as-> [1 2 3] input
  (map inc input)
  ;; get [2 3 4]
  (nth input 2)
  ;; which is 4 
  (conj [4 5 6] input [8 9 10]))

;; MODULES
;; "use"=use all functions in the modules

(use 'clojure.set)

;; so we imported set
(intersection #{1 2 3} #{2 3 4})

(difference #{1 2 3} #{2 3 4})

;; to use specific functions
(use '[clojure.set :only [intersection]])

;; use / to call functions from a module

;; require import modules
(require 'clojure.string)

(clojure.string/blank? "")

;; import functions with new names
(require '[clojure.string :as str])
(str/replace "This is a tester" #"[a-o]" str/upper-case)
;; (#"" denotes a regular expression literal)

;; we can also import java libraries
(import java.util.Date)
(ns test
  (:import java.util.Date
           java.util.Calendar))

;; instances: classname+.
(Date.)
;; use . also to call functions.
(. (Date.) getTime)
(.getTime (Date.))

;; but for static methods, use/
(Math/random)
(System/currentTimeMillis)




