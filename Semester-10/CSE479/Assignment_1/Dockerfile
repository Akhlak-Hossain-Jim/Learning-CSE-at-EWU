# Dockerfile for Apache/PHP with MySQLi extension
FROM php:8.1-apache

# Install MySQLi extension and required dependencies
RUN docker-php-ext-install mysqli && \
    docker-php-ext-enable mysqli

# Enable Apache mod_rewrite (optional, for clean URLs)
RUN a2enmod rewrite

# Set working directory
WORKDIR /var/www/html

# Copy application files
COPY . /var/www/html

# Set proper permissions
RUN chown -R www-data:www-data /var/www/html && \
    chmod -R 755 /var/www/html

