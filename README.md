# password-cracker

<div align="center">

![Top Language](https://img.shields.io/github/languages/top/julienbenac/password-cracker?style=for-the-badge&colorA=4c566a&colorB=5382a1&logo=openjdk&logoColor=white)
![Code Size](https://img.shields.io/github/languages/code-size/julienbenac/password-cracker?style=for-the-badge&colorA=4c566a&colorB=ebcb8b&logo=github&logoColor=white)
![License](https://img.shields.io/github/license/julienbenac/password-cracker?style=for-the-badge&colorA=4c566a&colorB=a3be8c)

</div>

Password cracker is a CLI tool, which illustrates the concept of password cracking. This tool uses brute force attack, which consists of testing all possible combinations until you find a convincing result. It is by no means a tool for professional use.

## Usage
```sh
$ java PasswordCracker <hash_function> <your_hash>
```
To take full advantage of the tool, you must first know hash of any password, avoid exceeding 4 or 5 characters because the calculation time is exponential. At the end, the tool tells you the search time, and the password corresponding to the hash.

### Available hash functions
The tool is capable of cracking passwords using 13 cryptographic hash functions, you will find an exhaustive list of these below. You must know the hash function used initially for the search algorithm to find a possible solution.
- [x] MD2
- [x] MD5
- [x] SHA-1
- [x] SHA-224
- [x] SHA-256
- [x] SHA-384
- [x] SHA-512
- [x] SHA-512/224
- [x] SHA-512/256
- [x] SHA3-224
- [x] SHA3-256
- [x] SHA3-384
- [x] SHA3-512

## Examples
```sh
# Run brute force search using MD5 algorithm
$ java PasswordCracker MD5 527bd5b5d689e2c32ae974c6229ff785
a
b
c
d
e
...
johi
johj
johk
johl
johm
Time to crack password : 62.182 seconds
Password cracked : john
```

```sh
# Run brute force search using SHA-256 algorithm
$ java PasswordCracker SHA-256 799ef92a11af918e3fb741df42934f3b568ed2d93ac1df74f1b8d41a27932a6f
a
b
c
d
e
...
dn%
doa
dob
doc
dod
Time to crack password : 1.257 seconds
Password cracked : doe
```

## Contributing
The source code of the tool is not subject to any copyright and no license, so feel free to clone the project and make improvements.