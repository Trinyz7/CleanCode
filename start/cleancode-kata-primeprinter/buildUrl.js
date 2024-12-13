function buildUrl(url, options = {}) {
    let baseUrl = processBaseUrl(url, options);
    baseUrl = appendPath(baseUrl, options.path);
    baseUrl = appendQueryParams(baseUrl, options.queryParams);
    baseUrl = appendHash(baseUrl, options.hash);
    return baseUrl;
}

function processBaseUrl(url, options) {
    if (url === null || typeof url === 'undefined') {
        return ''; 
    }
    if (typeof url === 'object') {
        return ''; 
    }
    return url; 
}

function appendPath(baseUrl, path) {
    if (!path) return baseUrl;
    return `${baseUrl}/${path}`;
}

function appendQueryParams(baseUrl, queryParams) {
    if (!queryParams || typeof queryParams !== 'object') return baseUrl;

    const queryString = Object.keys(queryParams)
        .map(key => `${encodeURIComponent(key)}=${encodeURIComponent(queryParams[key])}`)
        .join('&');

    return queryString ? `${baseUrl}?${queryString}` : baseUrl;
}

function appendHash(baseUrl, hash) {
    if (!hash) return baseUrl;
    return `${baseUrl}#${hash}`;
}
