# speech-synthesis

Library to speak text.

# Usage

Add this to your project.clj:
   
    [facts/speech-synthesis "1.0.0"]

Add to your ns:

    (:use [speech-synthesis.say :as say])

Turn speech to text:

    (say/say)
