#!/bin/sh
# This script is used to initialize a new repository

npm init
npm install -D typescript @types/chai @types/mocha ts-node mocha chai @types/mocha
tsc --init


