/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  async rewrites() {
    return [
      {
        source: '/api/:path*',
        destination: 'http://api:3001/api/:path*',
      },
    ]
  },
};

module.exports = nextConfig;
