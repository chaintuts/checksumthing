/** This file contains code for a simple checksum/hash calculation
*
* Author: Josh McIntyre
*/

package com.jmcintyre;

import java.security.*;

/* This class defines a class for calculating a cryptographic hash */
public class HashCalculate
{

	/* This function hashes input and returns a hexadecimal digest */
	public String calculateHash(String input, String algorithm)
	{

		try {
			
			// Hash the input
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(input.getBytes());
			byte[] digestBytes = messageDigest.digest();
			
			// Convert the digest to a hexadecimal string
			StringBuilder digestStringBuilder = new StringBuilder();
			for (byte digestByte : digestBytes) {
				digestStringBuilder.append(String.format("%02x", digestByte));
			}
			String digest = digestStringBuilder.toString();

			return digest;
		}
		catch(NoSuchAlgorithmException ex)
		{
			throw new RuntimeException(ex);
		}
	}

}