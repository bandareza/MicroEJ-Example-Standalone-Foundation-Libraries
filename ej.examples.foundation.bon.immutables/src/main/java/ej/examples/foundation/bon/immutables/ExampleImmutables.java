/*
 * Java
 *
 * Copyright 2009-2016 IS2T. All rights reserved.
 * 
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.bon.immutables;

import java.util.NoSuchElementException;

import ej.bon.Immutables;

/**
 * Demo on immutables usage
 *
 */
public class ExampleImmutables {

	public static void main(String[] args) {
		double[] tableCos;
		try{ tableCos = (double[])Immutables.get("tabcos"); }
		catch(NoSuchElementException e){
			e.printStackTrace();
			return;
		}

		double[] tableSin;
		try{ tableSin = (double[])Immutables.get("tabsin"); }
		catch(NoSuchElementException e){
			e.printStackTrace();
			return;
		}

		System.out.println("==== TABLE ====");
		for(int i=0; i<=90;++i){
			System.out.println("cos["+i+"] = "+tableCos[i]+"\t\t\t sin["+i+"] = "+tableSin[i]);
		}
		System.out.println("===============");

	}

}
