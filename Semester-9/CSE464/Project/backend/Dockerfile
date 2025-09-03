# Use an official Node.js runtime as a parent image
FROM node:18-alpine

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install any needed packages
RUN npm install

# Bundle app source
COPY . .

# Compile TypeScript
RUN npm run build

# Your app binds to port 3001 so you'll use the EXPOSE instruction to have it mapped by the docker daemon
EXPOSE 3001

# Define the command to run your app
CMD [ "node", "dist/index.js" ]
