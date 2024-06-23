# Base image with Node.js pre-installed
FROM node:20-alpine AS base

# Install corepack
ENV PNPM_HOME="/pnpm"
ENV PATH="$PNPM_HOME:$PATH"
RUN corepack enable

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json (if available) to the container
COPY package.json pnpm-lock.yaml ./

# Install dependencies
RUN pnpm install

# Copy the entire project directory to the container
COPY . .

# Build the React app for production
RUN pnpm run build

# Expose the port that your React app runs on (default is 3000)
EXPOSE 5173

# Command to run the React app
CMD ["pnpm", "dev"]
