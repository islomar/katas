#Fizzbuzz in Python

##Setup
1. Requirements:
  * pip:    https://pip.pypa.io/en/stable/installing/
  * Python (whatever version you want)
1. Create virtual environment (recommended)
2. Run `setup-fizzbuzz-dependencies.sh`


##Running the tests
* Execute `mamba --format=documentation fizzbuzz_spec.py`
* Parametrized tests: `nosetests test_fizzbuzz.py -v`


##Executing the app
`python main.py`


##Other solutions
https://github.com/APA42/fizzbuzzkata
https://github.com/jaimegildesagredo/fizzbuzz


##Process to install the requirements from local

Download requirements to local:
`pip install -r requirements-dev.txt --download requirements-downloads`
`ls requirements-downloads/`

Install requirements from local:
`pip install --no-index -f requirements-downloads/ -r requirements-dev.txt`