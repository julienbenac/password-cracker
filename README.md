# 🔑 password-cracker
Password cracker is a CLI tool, which illustrates the concept of password cracking. This tool uses brute force attack, which consists of testing all possible combinations until you find a convincing result. It is by no means a tool for professional use.

## Usage
```
$ java PasswordCracker <your_hash>
```
To take full advantage of the tool, you must first know SHA-256 hash of any password, avoid exceeding 4 or 5 characters because the calculation time is exponential. At the end, the tool tells you the search time, and the password corresponding to the SHA-256 hash.

## Example
```
$ java PasswordCracker 799ef92a11af918e3fb741df42934f3b568ed2d93ac1df74f1b8d41a27932a6f
a
b
c
d
e
f
...
dn*
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