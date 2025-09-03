# Provenance Data Explorer

This application is a web-based frontend to explore a database schema that includes detailed provenance and audit logs. It allows users to view data from various tables, see the history of records, and add new data.

## Tech Stack

- **Frontend:** Next.js, TypeScript, Tailwind CSS, daisyUI
- **Backend:** Node.js, Express.js
- **Database:** PostgreSQL
- **Containerization:** Docker & Docker Compose

## Prerequisites

Before you begin, ensure you have [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running on your system.

## Running the Application

1.  **Clone the repository** (or ensure you have the project files).

2.  **Navigate to the project directory** in your terminal:
    ```sh
    cd /path/to/the/project
    ```

3.  **Launch the application** using Docker Compose:
    ```sh
    docker-compose up --build -d
    ```
    This command will:
    - Build the Docker images for the frontend and backend services.
    - Start all three containers (database, backend, frontend) in the background.
    - The database will be automatically initialized with the required schema and sample data.

## Accessing the Application

Once the containers are running, open your web browser and navigate to:

**http://localhost:3000**

## Stopping the Application

To stop all running services and remove the containers, run the following command in the project directory:

```sh
docker-compose down
```
